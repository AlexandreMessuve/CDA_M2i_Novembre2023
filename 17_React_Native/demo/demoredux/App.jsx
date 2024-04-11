import { StyleSheet} from 'react-native'
import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { Provider } from 'react-redux'
import store from './store/store'
import { NavigationContainer } from '@react-navigation/native'
import MyId from './screens/MyId'
import Form from './screens/Form'


const Tab = createBottomTabNavigator()
const App = () => {
  return (
    <Provider store={store}>
        <NavigationContainer>
            <Tab.Navigator>
                <Tab.Screen name={'Home'} component={MyId} />
                <Tab.Screen name={'Form'} component={Form} />
            </Tab.Navigator>
        </NavigationContainer>
    </Provider>

  )
}

export default App

const styles = StyleSheet.create({})