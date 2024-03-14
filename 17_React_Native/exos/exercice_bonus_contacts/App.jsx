import React ,{useState, useEffect} from 'react'
import { NavigationContainer } from '@react-navigation/native'
import Contacts from './screens/Contacts'
import FormContact from './screens/FormContact'
import ContactDetail from './screens/ContactDetail'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import ContactContext from './context/contactContext'
const Stack = createNativeStackNavigator();
const App = () => {
    const [contacts, setContacts] = useState([]);
    const addContact = (newContact) => {
        setContacts([...contacts, newContact]);
    }
    const delContact = (idContact) => {
        const newContacts = contacts.filter((contact) => contact.id !== idContact);
        setContacts(newContacts);
    }
    useEffect(() => {
        console.log(contacts);
    }, [contacts])
  return (
    <NavigationContainer>
        <ContactContext.Provider value={{
            contacts,
            addContact,
            delContact
        }}>
            <Stack.Navigator initialRouteName={'Contacts'}>
                <Stack.Screen name={'Contacts'} component={Contacts} options={{headerShown: false}} />
                <Stack.Screen name={'FormContact'} component={FormContact} options={{title: 'Ajouter un contact'}} />
                <Stack.Screen name={'ContactDetail'} component={ContactDetail} />
            </Stack.Navigator>
        </ContactContext.Provider>

    </NavigationContainer>
  )
}

export default App