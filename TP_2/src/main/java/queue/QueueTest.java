package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

  public static final String something = "Something";
  static String first = "First";
  static String second = "Second";

  @Test public void test01NewQueueIsEmpty() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElements() {
    assertFalse( queueWith(something).isEmpty() );
  }

  @Test public void test03AddedElementIsAtHead() {
    assertEquals( something , queueWith(something).head() );
  }

  @Test public void test04TakeRemovesFirst() {
    Queue queue = queueWith(something);
    queue.take();
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastObject() {
    String addedObject = something;
    assertEquals( addedObject, queueWith(addedObject).take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = queueWithTwoElements();
    assertEquals( queue.take(), first );
    assertEquals( queue.take(), second );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstInQueue() {
    assertEquals( queueWithTwoElements().head(), first );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueWith(something);
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeCountsObjectsInTheQueue() {
    assertEquals( 2, queueWithTwoElements().size() );
  }

  @Test public void test10CanNotTakeInEmptyQueue() {
    assertEquals("Queue is empty",
            assertThrows(Error.class, () -> new Queue().take()).getMessage());
  }

  @Test public void test11CanNotTakeInEmptyQueueWithPreviousObjects() {
    Queue queue = queueWith(something);
    queue.take();
    assertEquals("Queue is empty",
            assertThrows(Error.class, () -> queue.take()).getMessage());

  }

  @Test public void test12CanNotHeadInEmptyQueue() {
    assertEquals("Queue is empty",
            assertThrows(Error.class, () -> new Queue().head()).getMessage());

  }

  private static Queue queueWith(String argument){
    return new Queue().add(argument);
  }

  public static Queue queueWithTwoElements() {
    return queueWith(first).add(second);
  }

}

