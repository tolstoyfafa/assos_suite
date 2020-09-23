import React from 'react'
import { Show, SimpleShowLayout, TextField, DateField} from 'react-admin';

export const GroupShow = (props) => (
<Show {...props}>
    <SimpleShowLayout>
        <TextField label="Nom" source="name" />
        <DateField label="Group cré le " source="creationDate" />
        <DateField showTime label="Dernière mise à jour le" source="modificationDate" />
    </SimpleShowLayout>
</Show>
)
