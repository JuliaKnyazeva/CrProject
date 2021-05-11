import lombok.Data;

@Data
public class FirstUser {



        private String signature;
        private String project;
        private int identifier;
        private String ip;



        public void setSignature(String signature) {
            this.signature = signature;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public void setIdentifier(int identifier) {
            this.identifier = identifier;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getSignature() {
            return signature;
        }

        public String getProject() {
            return project;
        }

        public int getIdentifier() {
            return identifier;
        }

        public String getIp() {
            return ip;
        }

}
