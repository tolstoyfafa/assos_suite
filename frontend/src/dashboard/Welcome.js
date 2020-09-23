import * as React from 'react';
import { Card} from '@material-ui/core';
import { makeStyles } from '@material-ui/styles';
import CardContent from '@material-ui/core/CardContent';
import { Title } from 'react-admin';

import backgroundImage from './welcome_bg.png';

const useStyles = makeStyles({
    root: {
        background: `url(${backgroundImage})`,
        color: '#fff',
        padding: 20,
        marginBottom: '1em',
    },
});

const Welcome = () => {
    const classes = useStyles();
    return (
        <Card className={classes.root}>
            
            <Title title="Bienvenue à la plateforme d'administration" />
        <CardContent>Bonjour et bienvenue à AssoSuite la plateforme de gestion de votre association.</CardContent>
        </Card>
    );
};

export default Welcome;
