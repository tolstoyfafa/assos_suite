import React from 'react'
import { Show, SimpleShowLayout, TextField, DateField} from 'react-admin';

export const AdherentShow = (props) => (
<Show {...props}>
    <SimpleShowLayout>
        <TextField label="Nom" source="firstName" />
        <TextField label="Prénom" source="lastName" />
        <TextField label="Couriel" source="mail" type="email" />
        <TextField label="Tél" source="phone" />
        <DateField label="Adhérent depuis le " source="creationDate" />
        <DateField showTime label="Dernière mise à jour le" source="modificationDate" />
        <TextField label="numéro de la rue" source="address.streetNum" />
        <TextField label="rue" source="address.street" />
        <TextField label="ville" source="address.city" />
        <TextField label="code postal" source="address.zip" />
        <TextField label="complément d'addresse" source="address.description" />
    </SimpleShowLayout>
</Show>
)
