import * as React from 'react';
import { forwardRef } from 'react';
import { AppBar, UserMenu, MenuItemLink} from 'react-admin';
import SettingsIcon from '@material-ui/icons/Settings';


const ConfigurationMenu = forwardRef((props, ref) => {
    return (
        <MenuItemLink
            ref={ref}
            to="/configuration"
            primaryText="Configuration"
            leftIcon={<SettingsIcon />}
            onClick={props.onClick}
        />
    );
});

const CustomUserMenu = (props) => (
    <UserMenu {...props}>
        <ConfigurationMenu />
    </UserMenu>
);

const CustomAppBar = (props) => {
    return (
        <AppBar {...props} elevation={1} userMenu={<CustomUserMenu />}>
        </AppBar>
    );
};

export default CustomAppBar;
