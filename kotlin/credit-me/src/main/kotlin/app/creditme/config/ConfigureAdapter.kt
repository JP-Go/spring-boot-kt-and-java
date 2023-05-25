package app.creditme.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class ConfigureAdapter {

  @Bean
  public fun userDetailsService(): UserDetailsService {
    val user: UserDetails = User.withUsername("user").password("{noop}user").roles("USER").build()
    val admin: UserDetails =
        User.withUsername("admin").password("{noop}admin").roles("USER", "MANAGER").build()
    val manager = InMemoryUserDetailsManager()
    manager.createUser(user)
    manager.createUser(admin)

    return manager
  }
}
