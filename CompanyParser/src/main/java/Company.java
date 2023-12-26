import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter @ToString
public class Company {
    private String name;
    private String description;
    private String logo;

    public Company() {}

    public Company(String companyName, String webInfo) {

    }

}
