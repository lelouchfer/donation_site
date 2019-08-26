package com.teslus.donation.services.impl;


import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Donator;
import com.teslus.donation.entities.Role;
import com.teslus.donation.entities.User;
import com.teslus.donation.repositories.DonatorRepository;
import com.teslus.donation.repositories.RoleRepository;
import com.teslus.donation.repositories.UserRepository;
import com.teslus.donation.services.UserService;
import com.teslus.donation.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {
    private static final String ROLE_DONATOR = "ROLE_DONATOR";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DonatorRepository donatorRepository;

    public User findByEmail(String email){
       return ( (UserRepository)getDao()).findByEmail(email);
    }

    public Map save(UserRegistrationDto registration){
        Map response = new LinkedHashMap();
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        Role role = roleRepository.findByName(ROLE_DONATOR);
        user.setRoles(Arrays.asList(role!=null ?role:roleRepository.save(new Role(ROLE_DONATOR))));
        User savedUser =userRepository.save(user);
        Donator donator = new Donator();
        donator.setIdCountry(registration.getIdCountry());
        donator.setDocumentNumber(registration.getNumDocument());
        donator.setIdDepartment(registration.getIdDepartament());
        donator.setIdDocument(registration.getIdDocument());
        donator.setIdUser(savedUser.getIdUser());
        donatorRepository.save(donator);
        response.put("completed", true);
        return response;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public CrudRepository<User, Integer> getDao() {
        return userRepository;
    }
}
