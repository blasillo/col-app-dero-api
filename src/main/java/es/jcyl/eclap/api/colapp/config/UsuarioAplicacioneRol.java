package es.jcyl.eclap.api.colapp.config;

import org.springframework.security.core.GrantedAuthority;

public enum UsuarioAplicacioneRol implements GrantedAuthority {
    ROLE_ADMINISTRADOR,
    ROLE_USUARIO;

    public String getAuthority() {
        return name();
    }
}
