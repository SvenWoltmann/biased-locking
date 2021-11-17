package eu.happycoders.biasedlocking;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class BiasedLockingVectorBenchmark {
  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }

  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
  public void test(Blackhole blackhole) {
    Vector<Integer> vector = new Vector<>(10_000_000);
    for (int i = 0; i < 10_000_000; i++) {
      vector.add(i);
    }
    blackhole.consume(vector);
  }
}
