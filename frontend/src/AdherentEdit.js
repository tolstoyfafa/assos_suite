import React from 'react';
import { Edit, SimpleForm, TextInput, DateInput, SelectInput,Toolbar,SaveButton, 
    required,
    minLength,
    maxLength,
    number,
    regex,
    email,
    } from 'react-admin';

const AdhrentEditToolbar = (props) => (<Toolbar {...props} >
        <SaveButton
            label="Modifier"
        />
    </Toolbar>);

const validateFirstName = [required("Le Nom est obligatoire"), minLength(2), maxLength(30)];
const validateEmail = [required("Le Prénom est obligatoire"), email()];
const validateZipCode = regex(/^\d{5}$/, 'Veuillez saisir un code postal valide');

export const AdherentEdit = (props) => (
    <Edit {...props} title="Modifier un adhérent" >
    <SimpleForm toolbar={<AdhrentEditToolbar/>} >
        <TextInput label="Nom" source="firstName" validate={validateFirstName}/>
        <TextInput label="Prénom" source="lastName" validate={validateFirstName} />
        <TextInput label="Couriel" source="mail" type="email" validate={validateEmail} />
        <TextInput label="Tél" source="phone" validate={[required("Le numéro de téléphone est obligatoire"),
                     number(), minLength(2), maxLength(15)]} />
        <TextInput label="numéro de la rue" source="address.streetNum" validate={[required(), number()]} />
        <TextInput label="rue" source="address.street" validate={[required("Le nom  de la rue est obligatoire")]} />
        <TextInput label="ville" source="address.city" validate={[required("Le nom de la ville est obligatoire")]} />
        <TextInput label="code postale" source="address.zip" validate={validateZipCode} />
        <TextInput label="supplément addresse" source="address.description" />
        <SelectInput label="sex" source="genderType" choices={[
            { id: 'MALE', name: 'Homme'},
            { id: 'FEMALE', name: 'Femme'},
        ]}  helperText={""}/>
        <SelectInput label="situation matrimoniale" source="familialSituation" choices={[
            { id: 'SINGLE', name: 'Célibataire'},
            { id: 'MARIED', name: 'Marié(e)'},
        ]}  helperText={""}/>
        <DateInput label="Naissance" source="birthDay"  validate={required()}/>
    </SimpleForm>
</Edit>
)