import * as React from "react";
import { List, Datagrid, TextField, EmailField, EditButton,ShowButton,DeleteButton} from 'react-admin';

export const AdherentList = props => (
    <List {...props}  >
        <Datagrid rowClick="show">
            <TextField source="firstName" label="Prénom"/>
            <TextField source="lastName" label="Nom"/>
            <EmailField source="mail" label="Couriel"/>
            <TextField source="phone" label="Téléphone"/>
            <EditButton label="Modifier" />
            <ShowButton label="Détails"/>
            <DeleteButton label="supprimer"/>
        </Datagrid>
    </List>
);