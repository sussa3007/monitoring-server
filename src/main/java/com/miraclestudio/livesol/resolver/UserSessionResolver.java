package com.miraclestudio.livesol.resolver;

import com.miraclestudio.livesol.annotation.UserSession;
import com.miraclestudio.livesol.user.entity.User;
import com.miraclestudio.livesol.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class UserSessionResolver implements HandlerMethodArgumentResolver {

    private final UserJpaRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 지원하는 파라미터 , 어노테이션 체크
        // AOP 방식으로 실행하기 위한 리졸버
        boolean annotation = parameter.hasParameterAnnotation(UserSession.class);
        boolean parameterType = parameter.getParameterType().equals(User.class);

        return annotation && parameterType;
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
        // support parameter 에서 true 반환시 여기 실행
        // JwtAuthorizationFilter 에서 Context에 userId 넣어둠
        // 사용자 정보 셋팅
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User principal = (User) authentication.getPrincipal();
        return principal;
    }
}