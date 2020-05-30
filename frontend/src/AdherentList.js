import * as React from "react";
import { List, Datagrid, TextField, EmailField } from 'react-admin';

export const AdherentList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="firstName" />
            <TextField source="lastName" />
            <EmailField source="mail" />
            <TextField source="phone" />
        </Datagrid>
    </List>
);