package com.server.youtube.config;

import com.server.youtube.domain.Member;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletRequest response) {
        // 클라이언트에서 보낸 토큰을 받아서 사용자 확인 후 인증 처리

        String token = parseBearerToken(request);

        if(token!=null) {
            Member member = tokenProvider.validate(token);
            // 추출한 인증 정보를 필터링에서 사용할 수 있도록 SecurityContext에 등록
            AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member, member.getPassword());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authentication);
            SecurityContextHolder.setContext(securityContext);
        }

        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWidth("Bearer")) {
            return bearerToken.substring(beginLndex:7);
        }

        return null;
    }
}
