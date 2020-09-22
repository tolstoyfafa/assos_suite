import { BACK_URL } from "./constants";
import decodeJwt from 'jwt-decode'


const auth_url = BACK_URL.concat("/authentication/authenticate")
export default {
    login: (opts) => {
        const request = new Request(auth_url, {
            method: 'POST',
            body: JSON.stringify({ 
                mail: opts.username,
                password: opts.password }),
            headers: new Headers({ 'Content-Type': 'application/json' }),
        });
        return fetch(request)
            .then(response => {

                if (response.status < 200 || response.status >= 300) {
                    throw new Error(response.message);
                }
                return response.json();
            })
            .then(({ token }) => {
                const decodedToken = decodeJwt(token);

                localStorage.setItem('token', token);
                localStorage.setItem('permissions', decodedToken.roles[0].authority);
            });
    },
    logout: () => {
        localStorage.removeItem('token');
        localStorage.removeItem('permissions');
        return Promise.resolve();
    },
    checkError: error => {
    },
    checkAuth: () => {
        return localStorage.getItem('token') ? Promise.resolve() : Promise.reject();
    },
    getPermissions: () => {
        const role = localStorage.getItem('permissions');
        return role ? Promise.resolve(role) : Promise.reject();
    }
};