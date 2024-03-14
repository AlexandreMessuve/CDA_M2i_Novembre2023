import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import Contacts from './screens/Contacts'
import FormContact from './screens/FormContact'
import ContactDetail from './screens/ContactDetail'
import { createNativeStackNavigator } from '@react-navigation/native-stack'

const Stack = createNativeStackNavigator();
const App = () => {
  return (
    <NavigationContainer>
        <Stack.Navigator initialRouteName={'Contacts'}>
            <Stack.Screen name={'Contacts'} component={Contacts} options={{headerShown: false}} />
            <Stack.Screen name={'FormContact'} component={FormContact} options={{title: 'Ajouter un contact'}} />
            <Stack.Screen name={'ContactDetail'} component={ContactDetail} />
        </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App