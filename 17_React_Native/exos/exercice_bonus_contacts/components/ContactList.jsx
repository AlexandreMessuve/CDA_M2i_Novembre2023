import { Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

const ContactList = (props) => {
    const [pressed, setPressed] = useState(false);
    const { contact, delContact, navigation } = props
    return (
        <View>
            <Pressable style={({pressed}) => [styles.item, (pressed) && styles.itemPressed]} 
            onPress={() => navigation.navigate('ContactDetail', {contact: contact})}>
                <Text style={styles.itemText}>
                    {contact.lastname} {contact.firstname}
                </Text>
                <Pressable 
                style={styles.button} 
                onPress={() => delContact(contact.id)}
                onPressIn={() => setPressed(true)}
                onPressOut={() => setPressed(false)}
                >
                   <Text style={[styles.iconRemove, pressed && styles.iconRemovePressed]}>X</Text>
                </Pressable>
            </Pressable>
        </View>
    )
}

export default ContactList

const styles = StyleSheet.create({
    
    item: {
        width: '100%',
        height: 80,
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        borderColor: 'black',
        borderBottomWidth: 3
    },
    itemText:{
        fontSize: 20,
        fontWeight: 'bold',
        marginLeft: 20,
        color: 'white',
    },
    itemPressed: {
        backgroundColor: '#B233FF'
    },
    pressed: {
        backgroundColor: '#FF6E33',
        borderRadius: 10
    },
    button: {
        marginRight: 50
    },
    iconRemove: {
        fontSize: 28,
        fontWeight: '800',
        color: 'red',
    },
    iconRemovePressed: {
        color: 'orange'
    }
})