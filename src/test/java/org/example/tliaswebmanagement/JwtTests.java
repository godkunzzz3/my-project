package org.example.tliaswebmanagement;

import org.example.tliaswebmanagement.pojo.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JwtTests {


    @Test
    public void testGenJwt() {
        // 1. 准备自定义载荷
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        // 2. 生成 JWT
        String jwt = JwtUtil.generateToken(claims);
        System.out.println("生成的JWT令牌：");
        System.out.println(jwt);

        // 3. 解析并校验 JWT
        Map<String, Object> parsedClaims = JwtUtil.parseToken(jwt);
        System.out.println("\n解析后的数据：");
        System.out.println("id: " + parsedClaims.get("id"));
        System.out.println("username: " + parsedClaims.get("username"));
    }
}
