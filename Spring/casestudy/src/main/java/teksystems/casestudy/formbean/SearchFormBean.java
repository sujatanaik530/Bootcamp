package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class SearchFormBean {
    @NotBlank (message = "Search string cannot be empty")
    private String search;
}
