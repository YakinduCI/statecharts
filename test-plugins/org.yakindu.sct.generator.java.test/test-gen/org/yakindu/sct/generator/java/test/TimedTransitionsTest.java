/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine.State;
import org.yakindu.scr.TimerService;
/**
 *  Unit TestCase for TimedTransitions
 */
@SuppressWarnings("all")
public class TimedTransitionsTest {

	private TimedTransitionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new TimedTransitionsStatemachine();
		statemachine.setTimer(new TimerService());
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testTimer01() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Start));
		try {
			Thread.sleep(2030);
		} catch (InterruptedException e) {
		}
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_End));
	}
}
