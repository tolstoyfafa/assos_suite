import React from "react";
import { Admin, Resource} from 'react-admin';
import dataProvider from './dataProvider'
import authProvider from './authProvider'
import {AdherentList} from './AdherentList'
import "./App.css";
import {BACK_URL}  from "./constants";
import { httpClient } from "./authorization";

const App = () => (
  <Admin title = "AssoSuite"
        dataProvider={dataProvider(BACK_URL, httpClient)}
        authProvider={authProvider} >
    <Resource 
        name="adherents"
        title="ADHERENTS"
        list={AdherentList} 
        >
    </Resource>
  </Admin>

)

export default App;
