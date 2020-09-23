import * as React from "react";
import { List, Datagrid, TextField, DateField} from 'react-admin';

export const GroupList = props => (
    <List {...props}  >
        <Datagrid rowClick="show">
            <TextField source="name" label="Nom"/>
            <DateField label="Groupe cré le" source="creationDate" />
            <DateField showTime label="Dernière mise à jour le" source="modificationDate" />
        </Datagrid>
    </List>
);