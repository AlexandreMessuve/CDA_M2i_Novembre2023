import React, { useState, useEffect } from 'react'
import { NavigationContainer } from '@react-navigation/native'
import Contacts from './screens/Contacts'
import FormContact from './screens/FormContact'
import ContactDetail from './screens/ContactDetail'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import ContactContext from './context/contactContext'
import axios from 'axios'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { StyleSheet } from 'react-native'
import Icon from 'react-native-vector-icons/FontAwesome6'

const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();


const MyStackNavigator = () => {
    return (
        <Stack.Navigator screenOptions={{ tabBarStyle: styles.color }}>
            <Stack.Screen name={'Contacts'} component={Contacts} options={{ headerShown: false }} />
            <Stack.Screen name={'ContactDetail'} component={ContactDetail} />
        </Stack.Navigator>
    )
}

const App = () => {
    const [contacts, setContacts] = useState([]);
    const addContact = (newContact) => {
        setContacts([...contacts, newContact]);
    }
    const delContact = (idContact) => {
        const newContacts = contacts.filter((contact) => contact.id !== idContact);
        setContacts(newContacts);
    }

    const fetchUsers = async () => {
        try {
            const resp = await axios.get('https://jsonplaceholder.typicode.com/users');
            const data = await resp.data;
            const contacts = data.map((contact) => {
                const names = contact.name.split(' ');
                // on retourne un nouvelle objet
                return {
                    id: contact.id,
                    username: contact.username,
                    firstname: names[0],
                    lastname: names[1],
                    phone: contact.phone,
                }

            });
            setContacts(contacts);

        } catch (e) {
            console.log(e);
        }
    }

    useEffect(() => {
        (async () => {
            await fetchUsers();
        })()
    }, []);

    useEffect(() => {
        console.log(contacts);
    });

    return (
        <NavigationContainer>
            <ContactContext.Provider value={{
                contacts,
                addContact,
                delContact
            }}>
                <Tab.Navigator initialRouteName={'Contacts'} screenOptions={{ tabBarStyle: styles.color }}>
                    <Tab.Screen
                        name={'Home'}
                        component={MyStackNavigator}
                        options={
                            {
                                headerShown: false,
                                tabBarIcon: ({color, size}) => (
                                    <Icon name={'user-group'} color={color} size={size}/>
                                )
                            }
                        } />
                    <Tab.Screen
                        name={'FormContact'}
                        component={FormContact}
                        options={
                            {
                                title: 'Ajouter un contact',
                                headerShown: false,
                                tabBarIcon: ({ color, size }) => (
                                    <Icon name={'user-plus'} color={color} size={size} />
                                )
                            }
                        } />
                </Tab.Navigator>
            </ContactContext.Provider>

        </NavigationContainer>
    )
}
const styles = StyleSheet.create({
    color: {
        backgroundColor: '#48245A'
    }
})
export default App