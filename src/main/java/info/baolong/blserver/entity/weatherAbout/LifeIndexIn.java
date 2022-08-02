package info.baolong.blserver.entity.weatherAbout;

import lombok.Data;

import java.util.List;

@Data
public class LifeIndexIn {
    private List<Ultraviolet> ultraviolet;
    private List<Dressing> dressing;

}