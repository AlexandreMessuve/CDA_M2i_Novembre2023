package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Identification {
    private String iMacAddress;
    private String ipAddress;

    @Override
    public String toString() {
        return "Imac address: " + iMacAddress + "\n Ip address: " + ipAddress;
    }
}
