package dtos;

import entities.Zoo;

import java.util.ArrayList;
import java.util.List;

public class ZoosDTO {

    List<ZooDTO> all = new ArrayList();

    public ZoosDTO(List<Zoo> zooList) {
        zooList.forEach((z) -> {
            all.add(new ZooDTO(z));
        });
    }

    public List<ZooDTO> getAll() {
        return all;
    }

    @Override
    public String toString() {
        return "Zoo = (" + all + "), ";
    }
}
