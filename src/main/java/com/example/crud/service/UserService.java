package com.example.crud.service;


import com.example.crud.config.auth.PrincipalDetail;
import com.example.crud.domain.user.User;
import com.example.crud.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public Long save(User user){
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        return userRepository.save(user).getId();
    }
    @Transactional
    public Long update(User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        User userEntity = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + user.getId()));
        userEntity.update(bCryptPasswordEncoder.encode(user.getPassword()), user.getNickname());
        principalDetail.setUser(userEntity); //추가
        return userEntity.getId();

    }
}
