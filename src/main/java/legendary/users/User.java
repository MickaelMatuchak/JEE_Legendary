package legendary.users;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

public class User implements Serializable {

        @Id
        @GeneratedValue
        private String id;
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}