import React from "react";
import { Admin, Resource,ListGuesser, EditGuesser} from 'react-admin';
import dataProvider from './dataProvider'
import authProvider from './authProvider'
import "./App.css";
import {BACK_URL}  from "./constants";

const App = () => (
  <Admin dataProvider={dataProvider(BACK_URL)} authProvider={authProvider} ></Admin>
)

export default App;
