package com.projeto.app.configs.tools;

import java.io.IOException;
import java.util.NoSuchElementException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projeto.app.configs.services.TokenService;
import com.projeto.app.models.Usuario;
import com.projeto.app.repositories.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {

    private TokenService TokenS;
    private UsuarioRepository UsuarioR;

    public AuthTokenFilter(TokenService tokenS, UsuarioRepository usuarioR) {
        TokenS = tokenS;
        UsuarioR = usuarioR;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = FindToken(request);
        boolean valid = TokenS.isValidToken(token);
        if (valid) {
            authenticate(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticate(String token) {
        Long id = TokenS.getId(token);
        try {
            Usuario usuario = UsuarioR.findById(id).get();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(), null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (NoSuchElementException e) {
            System.out.println("\n\t ACESSO NEGADO" + "\n\t TOKEN INVÁLIDO");
        }
    }

    private String FindToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }

}