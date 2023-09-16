package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

  @Test public void newQueueIsEmpty() {
    assertTrue( new Queue().isEmpty() );
  }
  @Test public void addElements() {
    assertFalse( QueueWithSomething().isEmpty() );
  }
  @Test public void addedElementInHead() {
    assertEquals( "Something", QueueWithSomething().head() );
  }

  @Test public void TakeRemovesFirst() {
    QueueWithSomething().take();
    assertTrue( QueueWithSomething().isEmpty() );
  }

  @Test public void TakeReturnsLastObject() {
    Queue queue = new Queue();
    String addedObject = "Something";
    queue.add( addedObject );
    assertEquals( addedObject, queue.take() );
  }

  @Test public void QueueBehavesFIFO() {
    Queue queue = new Queue();
    String firstAddedObject = "First";
    String secondAddedObject = "Second";

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void HeadReturnsFirstInQueue() {
    Queue queue = new Queue();
    String firstAddedObject = "First";

    queue.add( firstAddedObject );
    queue.add( "Second" );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = new Queue();
    queue.add( "Something" );
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( "First" ).add( "Second" ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = new Queue();
    queue.add( "Something" );
    queue.take();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    try {
      queue.head();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }
  private static Queue QueueWithSomething() {
    return new Queue().add("Something");
  }
}