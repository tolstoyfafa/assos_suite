import * as React from 'react';
import { Field, withTypes} from 'react-final-form';

import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CircularProgress from '@material-ui/core/CircularProgress';
import TextField from '@material-ui/core/TextField';

import LockIcon from '@material-ui/icons/Lock';
import { makeStyles } from '@material-ui/styles';
import { Notification } from 'react-admin';

const useStyles = makeStyles({
    main: {
        display: 'flex',
        flexDirection: 'column',
        minHeight: '100vh',
        alignItems: 'center',
        justifyContent: 'flex-start',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
    },
    card: {
        minWidth: 300,
        marginTop: '6em',
    },
    avatar: {
        margin: '1em',
        display: 'flex',
        justifyContent: 'center',
    },
    icon: {
        backgroundColor: 'blue',
    },
    hint: {
        marginTop: '1em',
        display: 'flex',
        justifyContent: 'center',
        color: 'grey',
    },
    form: {
        padding: '0 1em 1em 1em',
    },
    input: {
        marginTop: '1em',
    },
    actions: {
        padding: '0 1em 1em 1em',
    },
});

const renderInput = ({
    meta: { touched, error } = { touched: false, error: undefined },
    input: { ...inputProps },
    ...props
}) => (
    <TextField
        error={!!(touched && error)}
        helperText={touched && error}
        {...inputProps}
        {...props}
        fullWidth
    />
);

const { Form } = withTypes();
const Configuration = () => {
    const classes = useStyles();
    const handleSubmit = (auth) => {
        console.log("object")
    };

    return (
        <Form
            onSubmit={handleSubmit}
            validate={console.log("validate")}
            render={({ handleSubmit }) => (
                <form onSubmit={console.log("test")} noValidate>
                    <div className={classes.main}>
                        <Card>
                            <div >
                                <Avatar >
                                    <LockIcon />
                                </Avatar>
                            </div>
                            <div >
                                Changer mot de passe
                            </div>
                            <div >
                                <div >
                                    <Field
                                        autoFocus
                                        name="actual"
                                        // @ts-ignore
                                        component={renderInput}
                                        label="mot de passe actuel"
                                        disabled={false}
                                    />
                                </div>
                                <div >
                                    <Field
                                        autoFocus
                                        name="new_pass"
                                        // @ts-ignore
                                        component={renderInput}
                                        label="nouveau mot de passe"
                                        disabled={false}
                                    />
                                </div>
                                <div >
                                    <Field
                                        name="conf_pass"
                                        // @ts-ignore
                                        component={renderInput}
                                        label="confirmation mot de passe"
                                        type="password"
                                        disabled={false}
                                    />
                                </div>
                            </div>
                            <CardActions >
                                <Button
                                    variant="contained"
                                    type="submit"
                                    color="primary"
                                    disabled={false}
                                    fullWidth
                                >
                                    {false && (
                                        <CircularProgress
                                            size={25}
                                            thickness={2}
                                        />
                                    )}
                                    Changer
                                </Button>
                            </CardActions>
                        </Card>
                        <Notification />
                    </div>
                </form>
            )}
        />
    );
}
export default Configuration