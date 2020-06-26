import React from "react";
import { Admin, Resource} from 'react-admin';
import polyglotI18nProvider from 'ra-i18n-polyglot';
import frenchMessages from 'ra-language-french';
import dataProvider from './dataProvider'
import authProvider from './authProvider'
import {AdherentList} from './AdherentList'
import "./App.css";
import {BACK_URL}  from "./constants";
import { httpClient } from "./authorization";
import { AdherentCreate } from "./AdherentCreate";
import {AdherentEdit} from './AdherentEdit'
import { AdherentShow } from "./AdhrentShow";

const i18nProvider = polyglotI18nProvider(() => frenchMessages, 'fr');
const App = () => (
  <Admin title = "AssoSuite"
        dataProvider={dataProvider(BACK_URL, httpClient)}
        authProvider={authProvider}
        i18nProvider={i18nProvider} >
    <Resource 
        name="adherents"
        title="ADHERENTS"
        list={AdherentList}
        create={AdherentCreate} 
        edit={AdherentEdit}
        show={AdherentShow} 
        >
    </Resource>
  </Admin>

)

export default App;
