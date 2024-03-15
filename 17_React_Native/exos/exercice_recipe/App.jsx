import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import Categories from './screens/Categories'
import Meals from './screens/Meals'
import MealDetail from './screens/MealDetail'
const Stack = createNativeStackNavigator();


const App = () => {
  return (
    <NavigationContainer>
        <Stack.Navigator initialRouteName='Categories'>
            <Stack.Screen name='Categories' component={Categories} options={{title: 'All Categories'}}/>
            <Stack.Screen name='Meals' component={Meals} options={{title: 'Meals Overview'}}/>
            <Stack.Screen name='MealDetail' component={MealDetail}/>
        </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App