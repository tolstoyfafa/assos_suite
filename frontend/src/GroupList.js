import * as React from "react";
import { List, Datagrid, TextField, EmailField, EditButton,ShowButton,DeleteButton} from 'react-admin';

export const GroupList = props => (
    <List {...props}  >
        <Datagrid rowClick="show">
            <TextField source="name" label="Nom"/>
        </Datagrid>
    </List>
);