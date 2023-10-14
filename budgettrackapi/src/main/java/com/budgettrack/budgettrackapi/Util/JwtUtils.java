package com.budgettrack.budgettrackapi.Util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.budgettrack.budgettrackapi.Entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	
	private static String SECRET_KEY  = "Secret_Code";
	private static long expiryDuration = 60;
	
	public String generateJwt(UserEntity userEntity)
	{
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;
		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);
		
		Claims claims = Jwts
				.claims()
				.setIssuer(userEntity.getUserId().toString())
				.setIssuedAt(issuedAt)
				.setExpiration(expiryAt);
		
//		Optional claims put values
		claims.put("name", userEntity.getUserName());
		claims.put("type", userEntity.getUserType());
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}
	
	
	 public Claims verify(String authorization) throws Exception {
		 
	        try {
	            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authorization).getBody();
	            System.out.println("Verify method: claims: " +claims);
	            return claims;
	        } catch(Exception e) {
	            throw new Exception("Access Denied");
	        }

	    }

}
