import React from 'react';
import { Edit, SimpleForm, TextInput,Toolbar,SaveButton, 
    required,
    minLength,
    maxLength,
    } from 'react-admin';

const GroupEditToolbar = (props) => (<Toolbar {...props} >
        <SaveButton
            label="Modifier"
        />
    </Toolbar>);

const validateFirstName = [required("Le Nom est obligatoire"), minLength(2), maxLength(30)];

export const GroupEdit = (props) => (
<Edit {...props} title="Modifier un adhérent" >
    <SimpleForm toolbar={<GroupEditToolbar/>} >
        <TextInput label="Nom" source="name" validate={validateFirstName}/>
    </SimpleForm>
</Edit>
)