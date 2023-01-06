package Pojos;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadRequest {
    private String path;
    @Builder.Default
    private String mode = "add";
    private boolean autorename;
    private boolean mute;
}
