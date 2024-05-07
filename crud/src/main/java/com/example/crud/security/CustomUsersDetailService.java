package com.example.crud.security;

import com.example.crud.DB.Roles;
import com.example.crud.DB.Usuarios;
import com.example.crud.DB.IUsuariosRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUsersDetailService implements UserDetailsService {

    private IUsuariosRepository IUsuariosRepository;

    public CustomUsersDetailService(IUsuariosRepository IUsuariosRepository) {
        this.IUsuariosRepository = IUsuariosRepository;
    }

    public Collection<GrantedAuthority> mapToAuthorities(List<Roles> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuarios = IUsuariosRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(usuarios.getUsername(), usuarios.getPassword(), mapToAuthorities(usuarios.getRoles()));
    }
}
