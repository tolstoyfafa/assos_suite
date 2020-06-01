import * as React from "react";
import { List, Datagrid, TextField, EmailField, EditButton,ShowButton,DeleteButton } from 'react-admin';

export const AdherentList = props => (
    <List {...props} perPage={5} >
        <Datagrid rowClick="show">
            <TextField source="firstName" />
            <TextField source="lastName" />
            <EmailField source="mail" />
            <TextField source="phone" />
            <EditButton label="Modifier"/>
            <ShowButton label="Détails"/>
            <DeleteButton label="supprimer"/>
        </Datagrid>
    </List>
);