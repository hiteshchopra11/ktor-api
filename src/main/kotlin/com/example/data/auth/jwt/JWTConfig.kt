package com.example.data.auth.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.JWTVerifier
import com.example.data.models.UserCredentials
import java.util.*

object JwtConfig {

    fun getVerifier(secret: String, issuer: String, audience: String): JWTVerifier {
        return JWT
            .require(Algorithm.HMAC256(secret))
            .withAudience(audience)
            .withIssuer(issuer)
            .build()
    }

    /**
     * Produce a token for this combination of name and password
     */

    fun generateToken(user: UserCredentials, issuer: String, secret: String, audience: String): String {
        return JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("username", user.username)
            .withExpiresAt(getExpiration())  // optional
            .sign(Algorithm.HMAC256(secret))
    }

    /**
     * Calculate the expiration Date based on current time + the given validity
     */

    private const val validityInMs = 3600000 // 1 hour

    private fun getExpiration() = Date(System.currentTimeMillis() + validityInMs)

}