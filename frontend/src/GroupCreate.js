import React from "react";
import { Create,  SimpleForm, TextInput,Toolbar,SaveButton, 
    required,
    minLength,
    maxLength,
    } from 'react-admin';

const validateName = [required("Le Nom du groupe"), minLength(2), maxLength(30)];

const GroupCreateToolbar = (props) => (<Toolbar {...props} >
    <SaveButton
        label="Créer un groupe"
    />
</Toolbar>);

export const GroupCreate = (props) => (
    <Create {...props} title="Ajouter un adhérent" >
    <SimpleForm toolbar={<GroupCreateToolbar/>} >
        <TextInput label="Nom" source="name" validate={validateName}/>
    </SimpleForm>
</Create>
)

    


