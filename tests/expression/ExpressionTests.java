package expression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import environment.*;
import static org.junit.Assert.*;

public abstract class ExpressionTests<E extends Expression> {

	protected Environment env;
	protected printer.Infix printer;
	protected evaluator.Standard evaluator;
	protected E expressionEquals10;

	public abstract E createExpressionEquals10();

	@Before
	public void setUp() {
		env = new Environment();
		printer = new printer.Infix();
		evaluator = new evaluator.Standard();
		expressionEquals10 = createExpressionEquals10();
	}

	@After
	public void tearDown() {
		env = null;
		printer = null;
		expressionEquals10 = null;
	}

	@Test
	public abstract void testPrint();

	@Test
	public void testEvalEquals10() throws UnboundVariable {
		assertTrue(10 == expressionEquals10.eval(evaluator, env));
	}
}
