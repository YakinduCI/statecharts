/**
* Copyright (c) 2015 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "CastExpressions.h"

TEST(StatemachineTest, CastExpressionTest) {
	CastExpressions* statechart = new CastExpressions();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_realValue()== 5l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_intValue()== 5l);
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_realValue()== 15l);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(CastExpressions::main_region_C));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_realValue()== 757l);
	delete statechart;
}
