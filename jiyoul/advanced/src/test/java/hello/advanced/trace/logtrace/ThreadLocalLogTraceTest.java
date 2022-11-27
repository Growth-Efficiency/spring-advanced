package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

	ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

	@Test
	void beging_end_level2() {
		TraceStatus status1 = trace.begin("hello1");
		TraceStatus status2 = trace.begin("hello2");

		trace.end(status1);
		trace.end(status2);
	}


	@Test
	void beging_exception_level2() {
		TraceStatus status1 = trace.begin("hello1");
		TraceStatus status2 = trace.begin("hello2");

		trace.exception(status1, new IllegalArgumentException());
		trace.exception(status2, new IllegalArgumentException());
	}
}