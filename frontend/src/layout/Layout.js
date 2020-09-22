import React from 'react';
import { Layout } from 'react-admin';
import CustomAppBar from './CustomAppBar'

export default (props) => {
    return (
        <Layout
            {...props}
            appBar={CustomAppBar}
        />
    );
};
