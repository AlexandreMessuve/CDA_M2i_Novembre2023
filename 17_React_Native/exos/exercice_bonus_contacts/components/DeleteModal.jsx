import { Modal, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'

const DeleteModal = ({ visibility, id, username, closeModal, delContact }) => {
    return (
        <Modal transparent visible={visibility} animationType={'fade'} onRequestClose={closeModal}>
            <View style={styles.modal}>
                <View style={styles.container}>
                    <Text style={styles.title}>Voulez vous vraiment supprimer {username} ?</Text>
                    <View style={styles.buttonContainer}>
                        <Pressable onPress={() => { delContact(id); closeModal() }} style={({ pressed }) => [styles.button, styles.buttonRed, (pressed) && styles.buttonRedPressed]}>
                            <Text style={styles.textButton}>Oui</Text>
                        </Pressable>
                        <Pressable onPress={closeModal} style={({ pressed }) => [styles.button, styles.buttonBlue, (pressed) && styles.buttonBluePressed]}>
                            <Text style={styles.textButton}>Non</Text>
                        </Pressable>
                    </View>
                </View>
            </View>


        </Modal>
    )
}

export default DeleteModal

const styles = StyleSheet.create({
    modal: {
        height: '100%',
        width: '100%',
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        justifyContent: 'center',
        alignItems: 'center',
    },
    container: {
        width: 400,
        height: 150,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'white',
    },
    title:{
        fontSize: 20,
    },
    buttonContainer: {
        flexDirection: 'row',
        alignItems: 'center'
    },
    button: {
        marginHorizontal: 5,
        marginVertical: 6,
        alignItems: 'center',
        justifyContent: 'center',
        width: 100,
        height: 50,
        borderRadius: 5
    },
    buttonRed: {
        backgroundColor: '#FF3333'
    },
    buttonRedPressed: {
        backgroundColor: '#FF6E33'
    },
    buttonBlue: {
        backgroundColor: '#3374FF'
    },
    buttonBluePressed: {
        backgroundColor: '#33A2FF'
    },
    textButton:{
        fontSize: 15,
        color: 'white'
    }
})