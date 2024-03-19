import { Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useContext, useState } from 'react'
import contactContext from '../context/contactContext';
import Icon from 'react-native-vector-icons/FontAwesome6';
import DeleteModal from './DeleteModal';
const ContactList = ({username,id, navigation}) => {
    const [pressed, setPressed] = useState(false);
    const [modal, setModal] = useState(false);
    const {delContact} = useContext(contactContext);

    const closeModal = () => {
        setModal(false)
    }
    return (
        <View>
            <Pressable style={({pressed}) => [styles.item, (pressed) && styles.itemPressed]} 
            onPress={() => navigation.navigate('ContactDetail', {contactId: id})}>
                <Text style={styles.itemText}>
                    {username}
                </Text>
                <Pressable 
                style={styles.button} 
                onPress={() => setModal(true)}
                onPressIn={() => setPressed(true)}
                onPressOut={() => setPressed(false)}
                >
                   <Icon name={'trash-can'} size={25} style={[styles.iconRemove, pressed && styles.iconRemovePressed]} />
                </Pressable>
            </Pressable>
            <DeleteModal id={id} username={username} closeModal={closeModal} delContact={delContact} visibility={modal} />
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