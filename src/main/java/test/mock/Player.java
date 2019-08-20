package test.mock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * entity
 *
 * @author: yanzx
 * @date: 2019/08/21 00:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player implements Serializable {

    private String name;

    private int number;
}
