import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestPoint {

    @Test
    public void testPointFieldX(){
        GenericTestFactory.testFieldExists(Point.class,"x");
        GenericTestFactory.testFieldType(Point.class,"x",Integer.class,true);
        GenericTestFactory.testFieldModifier(Point.class,"x", Modifier.PRIVATE);
    }
    @Test
    public void testPointFieldY(){
        GenericTestFactory.testFieldExists(Point.class,"y");
        GenericTestFactory.testFieldType(Point.class,"y",Integer.class,true);
        GenericTestFactory.testFieldModifier(Point.class,"y", Modifier.PRIVATE);
    }

    @Test
    public void testCreatePointEmpty(){

        Point point = GenericTestFactory.getInstance(Point.class);
        List<Point> points = GenericTestFactory.invokeMethod(point,"createPoint",null);

        if(points.size() != 1)
            fail();
        int x = GenericTestFactory.getField(points.get(0),"x");
        int y = GenericTestFactory.getField(points.get(0),"y");
        if(x != 0 || y != 0)
            fail();
    }
    @Test
    public void testCreatePointFull(){

        int x = 10;
        int y = 15;
        Point point = GenericTestFactory.getInstance(Point.class);
        List<Point> points = GenericTestFactory.invokeMethod(point,"createPoint",new Object[]{x,y}, true);

        if(points.size() != 2)
            fail();

        Point correctPoint = GenericTestFactory.getProperObject(points, new String[]{"x","y"},new Object[]{x,y});

        int realX = GenericTestFactory.getField(correctPoint,"x");
        int realY = GenericTestFactory.getField(correctPoint,"y");
        if(x != realX || y != realY)
            fail();
    }

    @Test
    public void testTranslateMethod(){

        int x = 10;
        int y = 15;
        Point point = GenericTestFactory.getInstance(Point.class);
        List<Point> points = GenericTestFactory.invokeMethod(point,"createPoint",new Object[]{x,y}, true);

        if(points.size() != 2)
            fail();

        int translateX = 11;
        int translateY = 261;
        Point correctPoint = GenericTestFactory.getProperObject(points, new String[]{"x","y"},new Object[]{x,y});

        List<Point> translated = GenericTestFactory.invokeMethod(point,"translate",new Object[]{correctPoint,translateX,translateY}, true);

        if(translated.size() != 2)
            fail();

        Point realTranslated = GenericTestFactory.getProperObject(translated,new String[]{"x","y"},new Object[]{x+translateX,y+translateY});
        int realX = GenericTestFactory.getField(realTranslated,"x");
        int realY = GenericTestFactory.getField(realTranslated,"y");

        if(realX != x+translateX || realY != y+translateY)
            fail();
    }


}
